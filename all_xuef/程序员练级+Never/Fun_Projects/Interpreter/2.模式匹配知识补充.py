
##然而跟条件语句里的“条件”不同，每条 match 语句左边的模式，
##可以准确而形象地描述数据结构的形状，而且可以在匹配的同时，对结构里的成员进行“绑定”。
##这样我们可以在右边方便的访问结构成员，而不需要使用访问函数（accessor）或者 foo.x
##这样的属性语法（attribute）。
##而且模式可以有嵌套的子结构，所以它能够一次性的表示复杂的数据结构。


##模式匹配对解释器和编译器的书写相当有用，因为程序的语法树往往具有嵌套的结构。
##不用模式匹配的话，往往要写冗长，复杂，不直观的代码，才能描述出期望的结构。
##而且由于结构的嵌套比较深，很容易漏掉边界情况，造成错误。
##模式匹配可以直观的描述期望的结构，避免漏掉边界情况，而且可以方便的访问结构成员。

