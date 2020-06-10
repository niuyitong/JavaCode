import os
import time
from selenium import webdriver

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("C:\\Users\\打野晓姐姐\\Desktop\\selenium2html\\drop_down.html")
driver.get(file_path)
time.sleep(3)
opts = driver.find_elements_by_tag_name("option")
for opt in opts:
    if opt.get_attribute('value') == "7.45":
        opt.click()
time.sleep(3)
driver.quit()
