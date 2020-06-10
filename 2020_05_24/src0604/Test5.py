import os
import time
from selenium import webdriver

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\inner.html")
driver.get(file_path)
time.sleep(3)
driver.switch_to.frame("f2")
driver.find_element_by_id("kw").send_keys("笑话")
driver.find_element_by_id("su").click()
time.sleep(5)
#滚动条上下滚动
#js = "var q = document.documentElement.scrollTop=10000"
#driver.execute_script(js)
#滚动条左右上下同时滚动
js = "window.scrollTo(200,200)"
driver.execute_script(js)
time.sleep(3)
driver.switch_to.default_content()
driver.find_element_by_link_text("click").click()
time.sleep(3)
alert = driver.switch_to.alert
alert.accept()
time.sleep(3)
driver.quit()
