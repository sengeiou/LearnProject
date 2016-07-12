#include <stdio.h>


int main(){

        double  *p = new double;
        return 0;
}


/*
lesson9.c: In function ‘main’:
lesson9.c:6:22: error: ‘new’ undeclared (first use in this function)
         double  *p = new double;
                      ^
lesson9.c:6:22: note: each undeclared identifier is reported only once for each function it appears in
lesson9.c:6:26: error: expected ‘,’ or ‘;’ before ‘double’
         double  *p = new double;
                          ^
**/
