
#编程的宗派（OOP与FP孰优孰劣）--王垠
##所谓“类”和“对象”，基本是过程式语言里面的记录（record，或者叫结构，structure），
##它本质其实是一个从名字到数据的“映射表”（map）。
"""
这样你可以用point.r和point.angle访问它的模和角度。可是现在问题来了，如果你的代码开头
把Point定义为第一种XY的方式，使用point.x, point.y访问X和Y坐标，可是后来你决定改变
Point的存储方式，用极坐标，你却不想修改已有的含有point.x和point.y的代码，怎么办呢？

这就是“对象思想”的价值，它让你可以通过“间接”（indirection，或者叫做“抽象”）
来改变point.x和point.y的语义，从而让使用者的代码完全不用修改。虽然你的实际数据结构
里面根本没有x和y这两个成员，但由于.x和.y可以被重新定义，所以你可以通过改变.x和.y的
定义来“模拟”它们。在你使用point.x和point.y的时候，系统内部其实在运行两片代码，
它们的作用是从r和angle计算出x和y的值。这样你的代码就感觉x和y是实际存在的成员一样，
而其实它们是被临时算出来的。在Python之类的语言里面，你可以通过定义“property”来
直接改变point.x和point.y的语义。在Java里稍微麻烦一些，你需要使用point.getX()和
point.getY()这样的写法。然而它们最后的目的其实都是一样的——它们为数据访问提供了
一层“间接”（抽象）。


只有极少需要抽象的时候，你需要使用内嵌于对象之内，跟数据紧密结合的“方法”。
其他的时候，你其实只是想表达数据之间的变换操作，这些完全可以用普通的函数表达，
而且这样做更加简单和直接。这种把所有函数放进方法的做法是本末倒置的，因为函数
其实并不属于对象。绝大部分函数是独立于对象的，它们不能被叫做“方法”。
强制把所有函数放进它们本来不属于的对象里面，把它们全都作为“方法”，导致了面向对象
代码逻辑过度复杂。很简单的想法，非得绕好多道弯子才能表达清楚。很多时候这就像把自己
的头塞进屁股里面。


面向对象语言不仅有自身的根本性错误，而且由于面向对象语言的设计者们常常是半路出家，
没有受到过严格的语言理论和设计训练却又自命不凡，所以经常搞出另外一些奇葩的东西。

比如在JavaScript里面，每个函数同时又可以作为构造函数（constructor），所以每个函数里面都
隐含了一个this变量，你嵌套多层对象和函数的时候就发现没法访问外层的this，非得bind一下。

Python的变量定义和赋值不分，所以你需要访问全局变量的时候得用global关键字，后来又发现
如果要访问“中间层”的变量，没有办法了，所以又加了个nonlocal关键字。

Ruby先后出现过四种类似lambda的东西，每个都有自己的怪癖……
有些人问我为什么有些语言设计成那个样子，我只能说，很多语言设计者其实根本不知道自己在干什么！

"""


#函数式编程的优点
##函数式编程相对于面向对象最大的价值，莫过于对于函数的正确理解。
##很多所谓“面向对象设计模式”（design pattern），都是因为面向对象语言没有first-class function，
##所以导致了每个函数必须被包在一个对象里面才能传递到其它地方。

#函数式编程的另一个贡献，是它们的类型系统。
##函数式语言对于类型的思维，往往非常的严密。函数式语言的类型系统，往往比面向对象语言
##来得严密和简单很多，它们可以帮助你对程序进行严密的逻辑推理。然而类型系统一是把双刃剑，
##如果你对它看得太重，它反而会带来不必要的复杂性和过度工程。

"""
函数式语言的“拥护者”们，往往认为这个世界本来应该是“纯”（pure）的，不应该有
任何“副作用”。他们把一切的“赋值操作”看成低级弱智的作法。他们很在乎所谓尾递归，
类型推导，fold，currying，maybe type等等。他们以自己能写出使用这些特性的代码为豪。
可是殊不知，那些东西其实除了能自我安慰，制造高人一等的幻觉，并不一定能带来真正优秀可靠的代码。

"""

#很多喜欢自吹为“函数式程序员”的人，往往并不真的理解函数式语言的本质。
##他们一旦看到过程式语言的写法就嗤之以鼻。
"""
盲目鄙视赋值操作的人，也不理解“数据流”的概念。
其实不管是对局部变量赋值还是把它们作为参数传递，其实本质上都像是把一个东西放进一个管道，
或者把一个电信号放在一根导线上，只不过这个管道或者导线，在不同的语言范式里放置的方向和
样式有一点不同而已！
"""

#对数据结构的忽视
##数据结构的有些问题是“物理”和“本质”地存在的
##从数据结构的角度看，Lisp所谓的list就是一个单向链表。
##你必须从上一个节点才能访问下一个，而这每一次“间接寻址”，都是需要时间的。
#真正深邃的Lisp大师级人物，却知道什么时候应该使用记录（结构）或者数组。
#在什么时候该用链表，什么时候该用数组，是一门艺术。


#副作用的根本价值
"""
副作用这种东西，其实是根本的，有用的。对于这一点，我喜欢跟人这样讲：在计算机和电子线路最开头
发明的时候，所有的线路都是“纯”的，因为逻辑门和导线没有任何记忆数据的能力。后来有人发明了
触发器（flip-flop），才有了所谓“副作用”。是副作用让我们可以存储中间数据，从而不需要把所有
数据都通过不同的导线传输到需要的地方。没有副作用的语言，就像一个没有无线电，没有光的世界，
所有的数据都必须通过实在的导线传递，这许多纷繁的电缆，必须被正确的连接和组织，才能达到需要的效果。

"""


#fold以及其他
"""
大量使用fold和currying的代码，写起来貌似很酷，读起来却不必要的痛苦。
很多人根本不明白fold的本质，却老喜欢用它，因为他们觉得那是函数式编程的“精华”，可以显示自己的聪明。
然而他们没有看到的是，其实fold包含的，只不过是在列表（list）上做递归的“通用模板”，这个模板需要你
填进去三个参数，就可以生成一个新的递归函数调用。所以每一个fold的调用，本质上都包含了一个在列表上的
递归函数定义。fold的问题在于，它定义了一个递归函数，却没有给它一个一目了然的名字。
使用fold的结果是，每次看到一个fold调用，你都需要重新读懂它的定义，琢磨它到底是干什么的。
而且fold调用只显示了递归模板需要的部分，而把递归的主体隐藏在了fold本身的“框架”里。
比起直接写出整个递归定义，这种遮遮掩掩的做法，其实是更难理解的。

"""



#符号必须简单的对世界建模
##我编程的时候看到的不是表面的语言和程序，而是一个类似电路的东西。
##我看到数据的流动和交换，我看到效率的瓶颈，而这些都是跟具体的语言和范式无关的。

"""
编程最重要的事情，其实是让写出来的符号，能够简单地对实际或者想象出来的“世界”进行建模。
一个程序员最重要的能力，是直觉地看见符号和现实物体之间的对应关系。不管看起来多么酷的语言或者范式，
如果必须绕着弯子才能表达程序员心目中的模型，那么它就不是一个很好的语言或者范式。
有些东西本来就是有随时间变化的“状态”的，如果你偏要用“纯函数式”语言去描述它，
当然你就进入了那些monad之类的死胡同。最后你不但没能高效的表达这种副作用，而且让代码变得
比过程式语言还要难以理解。如果你进入另一个极端，一定要用对象来表达本来很纯的数学函数，
那么你一样会把简单的问题搞复杂。Java的所谓design pattern，很多就是制造这种问题的，
而没有解决任何问题。

"""





