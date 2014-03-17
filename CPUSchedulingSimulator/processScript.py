# -*- coding: utf-8 -*-
"""
Created on Mon Mar 17 13:26:49 2014

@author: Sayzar
"""
#f = open('yolotest', 'a') 
#f.write('yoloswagbitches \n')
#def processCreation(avgBurstTime, delay, priority):

from scipy.stats import norm

import random

def normalDis(fileName, avgBurstTime, procNumber):
    normalDisList = norm.rvs(avgBurstTime, avgBurstTime/6 , procNumber)
    f = open(fileName, 'a')   
    for i in normalDisList:
        n = int(i)
        r = random.randint(0,69) 
        prior = random.randint(0, 9)
        f.write(str(n) +' '+ str(r) + ' '+ str(prior) + '\n')


normalDis('fortyfcfs.dat', 40, 100)
normalDis('sixtyfcfs.dat', 60, 100)
normalDis('eightyfcfs.dat', 80, 100)
