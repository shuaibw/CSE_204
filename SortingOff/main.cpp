#include <random>
#include <iostream>
#include <memory>
#include <chrono>
#include<cassert>
#include<string>
#include <iomanip>
#include<limits>
#include<fstream>
//#include <sys/resource.h>
#include "apply_sort.h"

using namespace std;
enum Order {
    ASC,
    DESC,
    RAND
};
enum Sort {
    MERGE,
    QUICK
};
random_device rd;
mt19937 gen(rd());
//default_random_engine gen(static_cast<unsigned long int>(time(nullptr)));
uniform_int_distribution<> distrib(numeric_limits<int>::min(), numeric_limits<int>::max());

bool isSorted(const int ara[], int len) {
    for (int i = 0; i < len - 1; i++) {
        if (ara[i] > ara[i + 1]) return false;
    }
    return true;
}

void fill_ara(int ara[], int size, Order order) {
    int beg = distrib(gen);
    if (beg < 0) beg += size;
    else beg -= size;
    if (order == RAND)
        for (int n = 0; n < size; ++n) ara[n] = distrib(gen);
    else if (order == ASC)
        for (int n = 0; n < size; ++n) ara[n] = beg++;
    else
        for (int n = 0; n < size; ++n) ara[n] = beg--;
}

double do_sort(int runs, int size, Order order, Sort s) {
    auto times = make_unique<unsigned long long[]>(runs);
    void (*sort_func)(int *, int);
    if (s == MERGE) sort_func = apply_sort::merge_sort;
    else sort_func = apply_sort::quick_sort;
    for (int i = 0; i < runs; i++) {
        auto ara = make_unique<int[]>(size);
        fill_ara(ara.get(), size, order);
        auto start = chrono::high_resolution_clock::now();
        sort_func(ara.get(), size);
        auto stop = chrono::high_resolution_clock::now();
        assert(isSorted(ara.get(), size));
        auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
        times[i] = duration.count();
        if (size == 1000000)cout << times[i] / 1000000 << " ms required for pass " << i + 1 << '\n';
//        cout << "Run " << i << '\n';
//        for (int i = 0; i < size; i++) cout << ara[i] << '\n';
//        cout << (isSorted(ara.get(), size) ? "YES" : "NO") << '\n';
    }
    unsigned long long sum = 0;
    for (int i = 0; i < runs; i++) sum += times[i];
    sum /= 1000000;
    return static_cast<double>(sum) / runs;
}

void run_sort(Order order, Sort sort) {
    const int runs = 50;
    const int start_len = 10;
    const int end_len = 1000001;
    const int step = 10;
    const int iter = 6;
    int mag = 0;
    string s;
    if (order == RAND) s = "randomly generated";
    else if (order == ASC) s = "ascending";
    else s = "descending";
    cout << "Statistics for " << s << " numbers" << '\n';
    cout << setw(15) << left << "Magnitude" << "Time (ms)" << '\n';
    for (int i = start_len; i < end_len; i *= step, mag++) {
        double t = do_sort(runs, i, order, sort);
        cout << setw(15) << left << (mag + 1) << fixed << setprecision(3) << t << '\n';
    }
    cout << '\n';
}


int main() {
//    rlimit R;
//    getrlimit(RLIMIT_STACK, &R);
//    R.rlim_cur = R.rlim_max;
//    setrlimit(RLIMIT_STACK, &R);
//    ofstream out("output_linux.txt");
//    cout.rdbuf(out.rdbuf());
//    cout << "Analyzing mergesort avg over 50 runs/each order of magnitude" << '\n';
//    run_sort(RAND, MERGE);
//    run_sort(ASC, MERGE);
//    run_sort(DESC, MERGE);
    cout << "*************************" << '\n';
    cout << "Analyzing quicksort avg over 50 runs/each order of magnitude" << '\n';
    run_sort(RAND, QUICK);
    run_sort(ASC, QUICK);
    run_sort(DESC, QUICK);
//    out.close();
}