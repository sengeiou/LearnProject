cmake_minimum_required(VERSION 3.15)
project(Test2 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)
include_directories(advanced)
include_directories(const01)
include_directories(memory)
include_directories(pretreatment)
include_directories(variable)

add_executable(Test2
    advanced/string01.c
    advanced/string01.h
    const01/const01.c
    const01/const01.h
    memory/memory.c
    memory/memory.h
    pretreatment/pretreatment.c
    pretreatment/pretreatment.h
    variable/test1.c
    variable/test1.h
    ex16.c
    ex16.h
    main.c
    string.c
    string.h)
