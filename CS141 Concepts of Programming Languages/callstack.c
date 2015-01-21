// This is a C program, not a C++ program.
// Compile it using -std=c99

#include <assert.h>
#include <string.h>
#include <stdio.h>

char stack[100];			// The stack grows "left-to-right"
char *stackpointer = stack;

void pushToStack(void *data, int length) {
	// You will not have to check if you exceed the size of the stack.
	// TODO
	memcpy(stackpointer,data,length);
	stackpointer += length;

}

void popFromStack(void *data, int length) {
	// You will not have to check if you exceed the size of the stack.
	// TODO
	//memcpy to data
	stackpointer -= length;
	memcpy(data,stackpointer,length);
	
}

int addP(int a, int b) {
	// addP: add with parameters
	return a+b;
}

void addS() {
	// addS: add from stack
	// TODO
	int a,b, sum;
	popFromStack(&b, sizeof(b));
	popFromStack(&a, sizeof(a));
	
	sum = a+b;
	pushToStack(&sum, sizeof(sum));
}

double avgP(double a, double b) {
	return (a + b) / 2;
}

void avgS() {
	// TODO
	double a, b, avg;
	popFromStack(&b, sizeof(b));
	popFromStack(&a, sizeof(a));
	
	avg = (a+b) / 2;
	pushToStack(&avg, sizeof(avg));
}

long mulP(long a, short b) {
	return a * b;
}

void mulS() {
	// TODO
	long a, mult;
	short b;
	
	popFromStack(&b, sizeof(b));
	popFromStack(&a, sizeof(a));
	mult = (long)(a * b) ;
	pushToStack(&mult, sizeof(mult));
}

void incP(short *a) {
	(*a)++;
}

void incS() {
	// TODO
	short a;
	popFromStack(&a, sizeof(a));
	a++;
	pushToStack(&a, sizeof(a));

}

int countAP(char *str) {
	// This method counts all "a"s in a string (both lower and upper case)
	// TODO
    int count = 0;
    int i;
	for(i = 0; str[i] != 0 ; i++)
	{
		if(str[i] == 'a' || str[i] == 'A')
			count++;
	}
	return count;
}

void countAS() {
	// TODO
	int count = 0;
	char *str;
	popFromStack(&str, sizeof(str));
	int i = 0;
	for(i = 0; str[i] != 0 ; i++)
	{
		if(str[i] == 'a' || str[i] == 'A')
			count++;
	}
	pushToStack(&count, sizeof(count));
}

int main() {
	{
		int a = 15, b = 17, addP_result, addS_result;

		addP_result = addP(a, b);

		// TODO calculate addS_result by using addS
        pushToStack(&a, sizeof(a));
		pushToStack(&b, sizeof(b));
        addS();
        popFromStack(&addS_result, sizeof(addS_result));
		printf("add: %i %i\n", addP_result, addS_result);
		assert(addP_result == addS_result);
	}

	{
		double a = 15, b = 17, avgP_result, avgS_result;

		avgP_result = avgP(a, b);

		// TODO
 		pushToStack(&a, sizeof(a));
		pushToStack(&b, sizeof(b));
		avgS();
		popFromStack(&avgS_result, sizeof(avgS_result));
		printf("avg: %f %f\n", avgP_result, avgS_result);
		assert(avgP_result == avgS_result);
	}

	{
		long a = 100002l;
		short b = 3;
		long mulP_result, mulS_result;

		mulP_result = mulP(a, b);

		// TODO
		pushToStack(&a, sizeof(a));
		pushToStack(&b, sizeof(b));
		mulS();
		popFromStack(&mulS_result, sizeof(mulS_result));
		printf("mul: %li %li\n", mulP_result, mulS_result);
		assert(mulP_result == mulS_result);
	}

	{
		short aP = 5, aS = 5;

		incP(&aP);

		// TODO
		pushToStack(&aS, sizeof(aS));
		incS();
		popFromStack(&aS, sizeof(aS));
		printf("inc: %hi %hi\n", aP, aS);
		assert(aP == aS);
	}

	{
		char *str = "How many As does this string have?";
		int asP_result, asS_result;

		asP_result = countAP(str);

		// TODO
		pushToStack(&str, sizeof(str));
		countAS();
		popFromStack(&asS_result, sizeof(asS_result));
		printf("count: %i %i\n", asP_result, asS_result);
		assert(asP_result == asS_result);
	}

	return 0;
}