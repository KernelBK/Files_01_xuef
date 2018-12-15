
"""
一个特别有用的操作是将某种变换应用于一个表的所有元素;
而map就是对这一行为模式的抽象。

map建立起了一种处理表的高层抽象。

一种 表-->表 的变换
这种定义，并不在于计算机会执行不同的计算过程(其实不会)，
而在于我们对同样过程的不同思考方式!
"""
import operator as op
lst1 = [1, 2, 3]
lst2 = [10, 20, 30]

res = list(map(op.add, lst1, lst2))
print(res)