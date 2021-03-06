

def deco(func):
    def inner():
        print('running inner()')
        #func()
    return inner

@deco # 相当于 target = deco(target)
def target():
    print("target()")

target()
    

"""
严格来说，装饰器只是语法糖。如前所示，装饰器可以像常规的可调用
对象那样调用，其参数是另一个函数。有时，这样做更方便，尤其是做
元编程（在运行时改变程序的行为）时。

综上，装饰器的一大特性是，能把被装饰的函数替换成其他函数。
第二个特性是，装饰器在加载模块时立即执行。

函数装饰器在导入模块时立即执行，而被装饰的函数只在明确调用时运行。

虽然示例 7-2 中的 register 装饰器原封不动地返回被装饰的函数，但
是这种技术并非没有用处。很多 Python Web 框架使用这样的装饰器把函
数添加到某种中央注册处，例如把 URL 模式映射到生成 HTTP 响应的函
数上的注册处。这种注册装饰器可能会也可能不会修改被装饰的函数。
"""










