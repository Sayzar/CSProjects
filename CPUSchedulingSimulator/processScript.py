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

def normalDis(fileName, avgBurstTime, procNumber, priorNum):
    normalDisList = norm.rvs(avgBurstTime, avgBurstTime/6 , procNumber)
    priorList = norm.rvs(priorNum, 1, procNumber)
    f = open(fileName, 'a')   
    for i,j in zip(normalDisList, priorList):
        n = int(i)
        r = random.randint(0,69) 
        p = int(j)
        f.write(str(n) +' '+ str(r) + ' '+ str(p) + '\n')


normalDis('thirtyavgtwo.dat', 30, 100, 2)
normalDis('thirtyavgseven.dat', 30, 100, 7)
normalDis('seventyavgtwo.dat', 70, 100, 2)
normalDis('seventyavgseven.dat',70, 100, 7)