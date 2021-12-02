//
// Created by Shuaib on 08-Jun-21.
//

#ifndef SORTINGOFF_APPLY_SORT_H
#define SORTINGOFF_APPLY_SORT_H

#include<random>
#include<memory>
#include<chrono>
#include<ctime>
#include<limits>

using namespace std;

class apply_sort {
public:
    apply_sort() = delete;

    static void merge_sort(int ara[], int len) {
        int *aux = new int[len];
        do_merge_sort(ara, aux, 0, len - 1);
        delete[] aux;
    }

    static void quick_sort(int ara[], int len) {
        srand(time(nullptr));
        do_quick_sort(ara, 0, len - 1);
    }

private:
//    static mt19937 gen;
//    static uniform_int_distribution<int> dist;


    static void merge(int ara[], int aux[], int lo, int mid, int hi) {
        int i, j;
        for (i = lo; i <= hi; i++) aux[i] = ara[i];
        i = lo;
        j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) ara[k] = aux[j++];
            else if (j > hi) ara[k] = aux[i++];
            else if (aux[j] < aux[i]) ara[k] = aux[j++];
            else ara[k] = aux[i++];
        }
    }

    static void do_merge_sort(int ara[], int aux[], int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        do_merge_sort(ara, aux, lo, mid);
        do_merge_sort(ara, aux, mid + 1, hi);
        merge(ara, aux, lo, mid, hi);
    }

    static int partition(int ara[], int lo, int hi) {
//        int piv = lo + dist(gen) % (hi - lo + 1);
        int piv = lo + rand() % (hi - lo + 1);
        swap(ara[piv], ara[hi]);
        int x = ara[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (ara[j] < x) {
                i++;
                swap(ara[i], ara[j]);
            }
        }
        swap(ara[i + 1], ara[hi]);
        return i + 1;
    }

    static void do_quick_sort(int ara[], int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(ara, lo, hi);
        do_quick_sort(ara, lo, j - 1);
        do_quick_sort(ara, j + 1, hi);
    }

    static void swap(int &a, int &b) {
        int temp = a;
        a = b;
        b = temp;
    }

};


#endif //SORTINGOFF_APPLY_SORT_H
