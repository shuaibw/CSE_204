cmake_minimum_required(VERSION 3.17)
project(SortingOff)

set(CMAKE_CXX_STANDARD 14)
set(HEADERS apply_sort.cpp apply_sort.h)
set(SOURCES main.cpp)
add_executable(SortingOff ${SOURCES} ${HEADERS})
add_executable(rafi_test rafi_test.cpp)
add_executable(demo demo.cpp)