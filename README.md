# CreatPlatform
数据库乱码问题：
=====
在SSM框架搭建的项目中，当在页面表单提交（POST方式）汉字数据时，保存到数据库中是乱码，遇到这个情况有以下几个原因，等到一一排除改正之后，基本上不会出现这个问题了：    
这里我以UTF-8编码为标准，整个环节都是用UTF-8（也可以使用其它编码格式，但是要保证编码一致性）     
A  项目编码格式    
    无论使用什么IDE,创建一个新的项目时都会为项目工程默认指定一个编码，检查这个编码是否是自己决定的编码（一般默认为GBK）       
B springMVC的字符乱码过滤器没有配置     
  springMVC框架再web.xml中可以配置一个POST形式的编码过滤器，用于解决POST形式的各种乱码问题      
C  jsp页面编码      
    默认创建一个jsp页面的时候，其编码格式为ISO-8859-1，需要确保jsp页面为UTF-8     
D 数据库本身与系统应用的编码不一致      
   数据库也有自己对应的编码格式，如果这个编码格式与项目编码格式不一致，就回导致乱码问题（具体查看和设置方式可网上查询一下）     
E 配置数据连接池（如：dbcp连接池）的时候，这只数据库路径的时候，没有指定正确的字符编码格式同样会出现乱码     

这里我用了可视化工具Navicat，设置连接里面的连接属性，然后选中高级，在使用mysql字符集上打勾，使用默认的utf-8解决乱码问题。
尝试了很多方法，归根结底是Navicat连接属性字符集的问题。
