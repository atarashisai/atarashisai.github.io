#Reference
http://www.cplusplus.com/reference/
#IDE
IDE的选择：MS Visual Studio
#Compilor
编译器的选择：gcc
#Hello World
"Hello World"程序的要求是
	在终端（Terminal）上打印出：Hello World!
```cpp
/* "Hello World" Program in C */
#include <stdio.h>
int main()
{
    printf("Hello World!\n");
    return 0;
}
```
```cpp
/* "Hello World" Program in C++ */
#include <iostream>
int main()
{
    std::cout << "Hello World!\n";
    return 0;
}
```
#注释（Comment）
C语言只支持/**/标记的注释。
C++语言支持/**/标记的注释，和//标记的短注释。
```cpp
/* 
Long Comment, C Style Comment, or Inline Comment
    start from /* and end with */
/* For example: */a/**/++;
```
```cpp
// Short Comment starts from // and ends with new line.
```
#程序入口（Program Entry）
```cpp
/* Program Entry
int main()是标准的写法。
有些老旧的程序会用void main()和main()，这是因为编译器在背后进行了修正，现代程序应该尽量使用标准的写法：int main()。
*/
int main()
{
    /* Code Here */
    return 0; /* 返回值
当程序执行成功时，main的返回值是0。
当程序出错时，main的返回值应该是非0（non-zero）。*/
}
```
#分行符
在C/C++语言中，每一段指令（instruction）都要用;来标记结束。
```
[code];[code];[code];
```
#基础数据类型（Primary Data Types，Primitives）
```cpp
/* Primitives in C */
/*整型（整数）*/ int number = 5;
/*浮点（小数）*/ float decimal = 5.6;
/*双精度浮点（小数）*/ double pi = 3.141592658979;
/*字符（也可以是整数）*/ char letter = 'a'; char code = 25;
/*自动判断*/ auto unkown = "char array as you know";
```
```cpp
/* Additional Primitives in C++ */
/*真假值*/ bool positive = true; bool negative = false;
bool positive = 0; // 当赋值为0时，取值是真值（true）。
bool negative = 7; // 当赋值为非0时，会被修正为1，且取值为假值（false）。
/*长字符*/ wchar_t wch = L'A'; /* wchar_t用于unicode字符，长度是16位。
在字符的前面加上L能保证其长字符的特性，否则会被转型为短字符。*/
```