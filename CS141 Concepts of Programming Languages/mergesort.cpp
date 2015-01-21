#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <pthread.h>
#include <stdlib.h>
#define THREADS         5

void merge(std::vector<int>& v, size_t start, size_t lend, size_t rend) {
        std::vector<int> buf;
        size_t left = start;
        size_t right = lend;
        while(left < lend || right < rend) {
                if(left == lend) buf.push_back(v[right++]);                             // add the next element from the right side if no more elements are left on the left side, then increase `right`
                else if(right == rend) buf.push_back(v[left++]);                // other way round
                else if(v[left] <= v[right]) buf.push_back(v[left++]);  // left value smaller than right value - add left value to buffer and increase `left`
                else buf.push_back(v[right++]);                                                 // right value smaller
        }

        for(size_t i = start; i < rend; ++i) v[i] = buf[i-start];               // write buffer back to the actual vector
}

void mergesort(std::vector<int>& v) {
        for(size_t runsize = 1; runsize < v.size() * 2; runsize *= 2) {
                for(size_t run = 0; (run + 1) * runsize < v.size(); run += 2) {
                        merge(v, run * runsize, (run+1) * runsize, std::min((run+2) * runsize, v.size()));
                }
        }
}


void* parallel(void* p)
{
    std::vector<int>* v = static_cast<std::vector<int>*>(p);
   // std::cout << "Vector Size :" << v->size() << std::endl;
    for(size_t runsize = 1; runsize < v->size() * 2; runsize *= 2) {
        for(size_t run = 0; (run + 1) * runsize < v->size(); run += 2) {
            merge((*v), run * runsize, (run+1) * runsize, std::min((run+2) * runsize, v->size()));
        }
    }
    pthread_exit(NULL);
}
void parallel_mergesort(std::vector<int>& parallel_mergesort)
{
        pthread_t threads[THREADS];
        pthread_attr_t attr;
        void* status;
        int rc;

        pthread_attr_init(&attr);
        pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
        rc = pthread_create(&threads[0], NULL, parallel, (void*) &parallel_mergesort);
        pthread_attr_destroy(&attr);
        rc = pthread_join(threads[0], &status);
        for(unsigned int i = 0; i < THREADS; i++)
        {
            rc = pthread_create(&threads[i], NULL, parallel, (void*) & parallel_mergesort);
            if(rc)
            {
                exit(-1);
            }
        }

        pthread_attr_destroy(&attr);
        for(unsigned int i = 0; i < THREADS; i++)
        {
          rc = pthread_join(threads[i], &status);
          if(rc)
           {
             exit(-1);
           }
        }

}

int main() {
    std::fstream infile("data.txt", std::ios_base::in);
    std::fstream outfile_ms("mergesorted.txt", std::ios_base::out);
    std::fstream outfile_pms("parallelmergesorted.txt", std::ios_base::out);

    std::vector<int> vals;
    int a;
    while (infile >> a) {
        vals.push_back(a);
    }

    std::vector<int> mergesorted = vals;
    mergesort(mergesorted);
    for(std::vector<int>::iterator it = mergesorted.begin(); it != mergesorted.end(); ++it) {
        outfile_ms << *it << std::endl;
    }


    std::vector<int> parallel_mergesorted = vals;

    parallel_mergesort(parallel_mergesorted);
    for(std::vector<int>::iterator it = parallel_mergesorted.begin(); it != parallel_mergesorted.end(); ++it) {
        outfile_pms << *it << std::endl;
    }
  
    return 0;

}