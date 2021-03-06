
"""
** 表示一种传递参数的协议

要区分:
1. 函数定义中的 **args
2. 函数调用中的 **params

"""

def func(a, b, c):
    print(a+b+c)
    return a+b+c

func(a=1, b=1, c=1)

d={'b':5, 'c':7}

## 在函数调用中”**”做了什么？
## 它unpack字典，并将字典中的数据项作为键值参数传给函数。
## 因此,“fun(1, **d)”的写法与“fun(1, b=5, c=7)”等效

fun(1, **d)

