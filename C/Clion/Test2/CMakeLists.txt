cmake_minimum_required(VERSION 3.15)
project(Test2 C)

set(CMAKE_C_STANDARD 99)

add_executable(Test2 main.c ex16.c ex16.h string.h string.c const01/const01.h const01/const01.c memory/memory.h memory/memory.c)