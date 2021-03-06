
#http://blog.jobbole.com/21351/
#http://stackoverflow.com/questions/100003/what-is-a-metaclass-in-python

"""
Secondly, metaclasses are complicated. You may not want to use them for very simple
class alterations. You can change classes by using two different techniques:
·monkey patching
·class decorators
99% of the time you need class alteration, you are better off using these.

But 98% of the time, you don't need class alteration at all.
"""
##basic
"""
In most languages, classes are just pieces of code that describe how to produce an object.

Classes are objects too.

Yes, objects.

As soon as you use the keyword class, Python executes it and creates an OBJECT.
The instruction

>>> class ObjectCreator(object):
...       pass
...
creates in memory an object with the name "ObjectCreator".


This object (the class) is itself capable of creating objects (the instances),
and this is why it's a class.

But still, it's an object, and therefore:
·you can assign it to a variable
·you can copy it
·you can add attributes to it
·you can pass it as a function parameter
"""
class A():
    def f(self):
        pass

print(dir(A))

##Creating classes dynamically
"""
Since classes are objects, you can create them on the fly, like any object.

Since classes are objects, they must be generated by something.

When you use the class keyword, Python creates this object automatically.
But as with most things in Python, it gives you a way to do it manually.
"""

##What are metaclasses (finally)
"""
Metaclasses are the 'stuff' that creates classes.

MyClass = MetaClass()
my_object = MyClass()

type is the built-in metaclass Python uses, but of course, you can create your own metaclass.
"""

##The __metaclass__ attribute
"""
In Python 2, you can add a __metaclass__ attribute when you write a class
(see next section for the Python 3 syntax):

class Foo(object):
    __metaclass__ = something...
    [...]
If you do so, Python will use the metaclass to create the class Foo.

You write class Foo(object) first, but the class object Foo is not created in memory yet.

Python will look for __metaclass__ in the class definition. If it finds it, it will use
it to create the object class Foo. If it doesn't, it will use type to create the class.

"""

##Metaclasses in Python 3
"""
The syntax to set the metaclass has been changed in Python 3:

class Foo(object, metaclass=something):
"""



























