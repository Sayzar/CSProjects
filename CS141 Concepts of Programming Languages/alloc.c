#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

#define CHUNK_SIZE 64 // granularity - all allocated objects take at least this many bytes, must be at least sizeof(METAENTRY)

typedef struct METAENTRY {
	int size;
	char status; // either 0 for free or 1 for occupied
} METAENTRY;

typedef struct ARENA {
	void *memory;
	int size;
	METAENTRY *head;
} ARENA;

void printArena(ARENA *arena) {
    printf("[");

    METAENTRY *slot = arena->head;										// this is an address to a meta entry - now it is the first meta entry (stored at arena->head)
    while((char*)slot < (char*)arena->memory + arena->size) {			// we want to loop through the arena. if the address that slot is pointing to is outside of the arena, we need to stop
        printf("M");													// we increment slot always in a way so that it points to a meta entry
        int i;
        for(i = 0; i < slot->size / CHUNK_SIZE; ++i) {				// we take the size of the current slot, divide it by the chunk size, and print
            printf("%c", (slot->status ? 'X' : ' '));					// either X or ' ', depending on the status of the slot
        }
        slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);	// now we go to the next meta entry. For this, we take the address of the current one (slot), add CHUNK_SIZE (the size of the meta entry itself, and the size of the slot
    }

    printf("]\n");
}

void printPositionInArena(ARENA *arena, void *addr) {
	printf(" ");
	int slot = ((char*)addr - (char*)arena->memory) / CHUNK_SIZE;
	int i;
	for(i = 0; i < slot; ++i) printf(" ");
	printf("^\n");
}

ARENA* createArena(int size) {
	assert(size % CHUNK_SIZE == 0);
	assert(sizeof(METAENTRY) < CHUNK_SIZE);

	ARENA *arena = (ARENA*) malloc(sizeof(ARENA));		// Allocate memory for the arena struct (that stores information about the arena, but not the memory for the allocator itself)

	arena->memory = malloc(size);						// Allocate memory that we will hand out
	arena->size = size;									// Store the size of the arena for looping over it

	METAENTRY *head = (METAENTRY*) arena->memory;		// Cast the first chunk in the arena to a METAENTRY*
	head->size = size - CHUNK_SIZE;						// The size of the first slot is the full memory size minus one chunk for the first METAENTRY
	head->status = 0;									// The memory is free
	arena->head = head;									// METAENTRYs are a linked list. We store the head of the list in the arena. (This is always the first chunk - we could also recalculate it.)

	return arena;
}

void *allocate(ARENA *arena, int size) {
	size = ((size + CHUNK_SIZE - 1) / CHUNK_SIZE) * CHUNK_SIZE;				// round up size to the next multiple of CHUNK_SIZE

	METAENTRY *slot = arena->head;											// get a pointer to the first METAENTRY
	while((char*)slot < (char*)arena->memory + arena->size) {				// iterate over METAENTRYs until we reach the end of the memory
		if(slot->status == 1) {												// if the slot is already occupied,
			slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);	// go to the next slot. this is done by increasing slot by CHUNK_SIZE (for the meta entry) and slot->size (the size of this slot)
			continue;
		} else if(slot->size < size) {										// the slot is too small
			slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);	// go to the next slot (see above)
			continue;
		} else if(slot->size < size + 2*CHUNK_SIZE) {						// the slot is big enough, but splitting does not make sense as we have less than 2 free chunks left in the slot. One of that is needed for another metaentry, so we need at least another chunk for the user's data
			slot->status = 1;												// mark the slot as occupied
			void *addr = (void*)((char*) slot + CHUNK_SIZE);				// calculate the position at which the user can write - this is the address of the slot plus one chunk size (to skip the METAENTRY)
			slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);	// go to the next slot
			return addr;
		} else {															// we have >= chunks that are unused in this slot - split the slot
			int oldsize = slot->size;
			void *addr = (void*)((char*) slot + CHUNK_SIZE);				// calculate the position at which the user can write
			slot->status = 1;												// mark as occupied
			slot->size = size;												// reduce the size to the needed size
			slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);	// advance the slot pointer. We are now behind the memory area were the user would write the data and need to add a new METAENTRY there
			slot->status = 0;												// that METAENTRY points to an empty slot
			slot->size = oldsize - size - CHUNK_SIZE;						// the size of that slot is the size of the old slot minus the size that we just allocated, minus one slot for the new METAENTRY
			return addr;
		}
	}

	return 0;																// return 0 if we did not find any empty memory
}

// TODO Your part starts here - you won't have to modify anything above.

void coalesce(ARENA *arena) {
	// TODO find free entries that follow each other and join them
	METAENTRY *slot = arena->head;
	METAENTRY *nextSlot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);
	while((char*)slot < (char*)arena->memory + arena->size)
    {
		if(nextSlot->status == 0 && slot->status == 0)
		{
              slot->size += nextSlot->size + CHUNK_SIZE;
		}
		slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);
		nextSlot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);
	}

}

void deallocate(ARENA *arena, void *addr) {
	// TODO find appropriate entry in list and set its status to 0
	METAENTRY *slot = arena->head;
	while((char*)slot < (char*)arena->memory + arena->size)
	{
		if((addr-CHUNK_SIZE) == (slot))
		{
			slot->status = 0;
		}
		slot = (METAENTRY*)((char*) slot + CHUNK_SIZE + slot->size);
	}
	coalesce(arena);
}

void deleteArena(ARENA *arena) {
	// TODO free up the memory that you allocated before
	free(arena->memory);
    free(arena);
}

int main () {
	ARENA *arena = createArena(64 * CHUNK_SIZE);

	printf("BEGIN\n");
	printArena(arena);

	printf("\nALLOC a\n");
	void *a = allocate(arena, 10);
	printArena(arena);
	printPositionInArena(arena, a);

	printf("\nALLOC b\n");
	void *b = allocate(arena, 128);
	printArena(arena);
	printPositionInArena(arena, b);

	printf("\nALLOC c\n");
	void *c = allocate(arena, 267);
	printArena(arena);
	printPositionInArena(arena, c);

	printf("\nDEALLOC a\n");
	deallocate(arena, a);
	printArena(arena);

	printf("\nDEALLOC c\n");
	deallocate(arena, c);
	printArena(arena);

	printf("\nALLOC d\n");
	void *d = allocate(arena, 10);
	printArena(arena);
	printPositionInArena(arena, d);

	printf("\nDEALLOC b\n");
	deallocate(arena, b);
	printArena(arena);

	printf("\nALLOC e\n");
	void *e = allocate(arena, 10);
	printArena(arena);
	printPositionInArena(arena, e);

	printf("\nDEALLOC e\n");
	deallocate(arena, e);
	printArena(arena);

	printf("\nALLOC f\n");
	void *f = allocate(arena, 3000);
	printArena(arena);
	printPositionInArena(arena, e);

	printf("\nALLOC g\n");
	void *g = allocate(arena, 100);
	printArena(arena);
	printPositionInArena(arena, g);

	printf("\nALLOC h\n");
	void *h = allocate(arena, 300);
	printArena(arena);
	printPositionInArena(arena, h);

	printf("\nALLOC i\n");
	void *i = allocate(arena, 200);
	printArena(arena);
	printPositionInArena(arena, i);

	printf("\nDEALLOC d\n");
	deallocate(arena, d);
	printArena(arena);

	printf("\nDEALLOC f\n");
	deallocate(arena, f);
	printArena(arena);

	printf("\nDEALLOC g\n");
	deallocate(arena, g);
	printArena(arena);

	printf("\nDEALLOC h\n");
	deallocate(arena, h);
	printArena(arena);

	printf("\nDEALLOC i\n");
	deallocate(arena, i);
	printArena(arena);

	deleteArena(arena);

	return 0;
}