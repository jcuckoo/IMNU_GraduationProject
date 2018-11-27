#-*- coding=utf8 -*-
import sys
reload(sys)
sys.setdefaultencoding("utf-8")
import urllib2
import re
from bs4 import BeautifulSoup
import datetime
# 实现下载HTML网页源码的函数，url为地址
def DownLoad_Html(url):
    try:
        html = urllib2.urlopen(url).read()
    except urllib2.URLError as e:
        print "error"
        print e.code  # 可以打印出来错误代号如404。
        print e.reason  # 可以捕获异常
        html = None
    return html
def select_li(url):
    html = DownLoad_Html(url)
    soup = BeautifulSoup(str(html), "html.parser")
    for i in range(0,20):
        data = soup.find_all('li', attrs={'data-index':str(i)})
        print data[0]
if __name__=='__main__':
    url = 'https://bj.lianjia.com/zufang/xicheng/'
    select_li(url)
    # html = DownLoad_Html(url)
    # print html