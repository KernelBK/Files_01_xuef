
#出于什么样的原因，诞生了「协程」这一概念？
#https://www.zhihu.com/question/50185085

"""
程序开发的一大矛盾是，你要用控制流去完成逻辑流。

在刚开始学程序的时候，往往都是从控制流等价于执行流的情况下学起，执行到哪，就意味着逻辑走到了哪。
这样的程序结构清晰，可读性好。

但是问题是中间有些过程是不能立即得到结果的，程序为了等结果就会阻塞。这种情况多见于一些io操作。
为了提升效率，我们可以使用异步的api，通过回调/通知函数来响应操作结果，同时接着执行下一轮的逻辑。

异步回调/通知的问题在于，它把原本统一的逻辑流拆开成了几个阶段，这样控制流和逻辑流就不等价了。
为了保证逻辑数据的传递，需要自己来维护状态，阅读起来也比较头疼。状态的维护历来就是bug层出的地方，
很容易掉入无效状态而死掉。

协程是一种任务调度机制，它可以让你用逻辑流的顺序去写控制流，而且还不会导致操作系统级的线程阻塞。
你发起异步请求、注册回调/通知器、保存状态，挂起控制流、收到回调/通知、恢复状态、恢复控制流的
所有过程都能过一个yield来默默完成。

从代码结构上看，协程保证了编写过程中的思维连贯性，使得函数（闭包）体本身就无缝保持了程序状态。
逻辑紧凑，可读性高，不易写出错的代码，可调试性强。

从实现上看，与线程相比，这种主动让出型的调度方式更为高效。一方面，它让调用者自己来决定什么时候让出，
比操作系统的抢占式调度所需要的时间代价要小很多。后者为了能恢复现场会在切换线程时保存相当多的状态，
并且会非常频繁地进行切换。另一方面，协程本身可以做在用户态，每个协程的体积比线程要小得多，因此一个
进程可以容纳数量相当可观的逻辑流。

举个例子，openresty中的ngx_lua组件就使用了协程来管理所有的io接口，极大地提升了服务器的负载能力。

作者：PaintDream
链接：https://www.zhihu.com/question/50185085/answer/183463734

"""

"""
1.  协程间切换是被程序员控制的， 一个协程是否已经就绪是程序员知道的。
协程调度器只会切换到已经就绪的协程。当所有工作协程都陷入等待态（等有数据可读，等连接建立完成。。）
时，最后一个要等待的协程就得切换到那个可以epoll的协程来驱动未来协程们的唤醒
（类似于进程的所有线程都sleep了？请切换到内核去）。

总之：协程开始在高性能网络服务中使用，就说明用户态程序员认清自己是在做类似内核中断例程开发，
不再尝试用一个函数入口处理完操作系统的所有中断请求了。

作者：朱元
链接：https://www.zhihu.com/question/50185085/answer/183839619

"""

"""
补充一点，发展历史上，是先有的协程（合作式多任务），后有的线程（抢先式多任务）。
这还不算协程在无数特殊场合被重新发明，毕竟协程可以在用户态实现，不用进入内核态。
"""














