#include <stdio.h>

// 找出字符中非空字符的个数
int getCharNum(char str[])
{
    int count = 0;
    char *p = str;
    while (*p)
    {
        if (*p != ' ')
        { // 这里注意 " "(地址) 和 ' '（字符）
            count++;
        }
        p++;
    }

    return count;
}

void getCharNum2(char str[])
{
    int result[40] = {0};
    while (*str)
    {
        result[*str - 'a']++;
        str++;
    }
    for (int i = 0; i < 26; i++)
    {
        if (result[i])
        {
            printf("%c = %d \t", i + 'a', result[i]);
        }
    }
}

int main()
{
    char str[] = "aahskjdh";

    int num = getCharNum(str);

    printf("the number is %d \n", num); //''

    getCharNum2(str);
    return 0;
}
