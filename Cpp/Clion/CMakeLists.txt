cmake_minimum_required(VERSION 3.16)
project(Clion)

set(CMAKE_CXX_STANDARD 11)

add_executable(Clion main.cpp src/pointer.h src/pointer.cpp src/class/class1.h src/class/class1.cpp)