# -*- coding: utf-8 -*-
"""
Created on Fri Jul  5 22:27:09 2019

@author: hpt09
"""

import argparse
import json
import re

def atoi(text):
    if text.isdigit():
        return int(text) 
    else:
        return text

def natural_keys(text):
    return [ atoi(c) for c in re.split('(\d+)',text) ]

# =============================================================================
# parser = argparse.ArgumentParser()
# parser.add_argument("word")
# args = parser.parse_args()
# =============================================================================


with open('output.txt') as f:
    data = json.load(f)

with open('expletives.txt') as f:
    mylist = f.read().splitlines()

wordTimesList = []
wordTimes = ""

for x in mylist:
    for row in data:
        if x in row['word']:
            startTime = row['start']
            endTime = row['end']
            wordTimesList.append(str(startTime) + "-" + str(endTime))
            

#Need to sort wordTimes
wordTimesList.sort(key=natural_keys)

#Printing         
for x in wordTimesList:
    wordTimes = wordTimes + x + "\n"

print(wordTimes)




