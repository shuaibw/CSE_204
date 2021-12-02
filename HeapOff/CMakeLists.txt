cmake_minimum_required(VERSION 3.17)
project(HeapOff)

set(CMAKE_CXX_STANDARD 14)

add_executable(HeapOff main.cpp heap.h)
add_executable(test test.cpp)