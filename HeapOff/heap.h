//
// Created by Shuaib on 06-Apr-21.
//

#ifndef HEAPOFF_HEAP_H
#define HEAPOFF_HEAP_H

#include<vector>

class Heap {
private:
    int *ara;
    unsigned n;
    unsigned sz;

    inline void max_heapify(int i) {
        while (i < sz) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int largest = (l < sz && ara[l] > ara[i]) ? l : i;
            if (r < sz && ara[r] > ara[largest]) largest = r;
            if (largest == i) break;
            swap(i, largest);
            i = largest;
        }
    }

    void swap(int a, int b) {
        int temp = ara[a];
        ara[a] = ara[b];
        ara[b] = temp;
    }

public:
    Heap(unsigned int size) : n{size}, ara{new int[size]}, sz{0} {
    }

    void insert(int item) {
        if (sz >= n) throw std::overflow_error("Heap size full");
        int i = sz;
        ara[sz++] = item;
        int p = (i - 1) / 2;
        while (ara[p] < ara[i]) {
            swap(i, p);
            i = p;
            p = (i - 1) / 2;
        }
    }

    unsigned size() const {
        return sz;
    }

    int getMax() const {
        return sz != 0 ? ara[0] : -1;
    }

    void deleteKey() {
        if (sz == 0) throw std::underflow_error("Heap empty, no keys to delete");
        swap(0, --sz);
        max_heapify(0);
    }

    friend void heapsort(std::vector<int> &v);

    ~Heap() {
        delete[] ara;
    }

};

void heapsort(std::vector<int> &v);

void heapsort(std::vector<int> &v) {
    if (v.empty() || v.size() == 1) return;
    Heap heap(v.size());
    for (const auto &e: v) heap.insert(e);
    int v_idx = 0;
    for (int i = heap.sz - 1; i > 0; i--) {
        v[v_idx++] = heap.ara[0];
        heap.swap(i, 0);
        heap.sz--;
        heap.max_heapify(0);
    }
    v[v_idx] = heap.ara[0];
}

#endif //HEAPOFF_HEAP_H
