# python2 使用 urllib2.urlopen()
import urllib.request
import urllib.parse


def download(url):
    user_agent='Mozilla/4.0(compatible;MSIE 5.5; Windows NT)'
    headers ={ 'User-Agent':user_agent}
    req = urllib.request.Request(url,headers = headers)
    # req.add_header("", "")
    response = urllib.request.urlopen(req)
    print(response.getcode())
    print(response.geturl()) # 有时会转发或重定向
    return response.read() # 响应的报头
    #response.read(100)

url = """
https://s3.music.126.net/web/s/core_e75d14aff11ef77224105423dfe65396.js?e75d14aff11ef77224105423dfe65396

"""
def main():
    try:
        data=download(url)
        with open("js.txt", "wt") as f:
            print(data, file=f)
        
    except URLError as e:
        print("error")

def main2():
    en=urllib.parse.urlencode({"word":"笑傲江湖"})
    print(en)
if __name__ == '__main__':
    main()
    #main2()
