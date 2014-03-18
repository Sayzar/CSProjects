# -*- coding: utf-8 -*-
"""
Created on Mon Mar 17 13:26:49 2014

@author: Sayzar
"""
from scipy.stats import norm

import random

def normalDisPrior(fileName, avgBurstTime, procNumber, priorNum):
    normalDisList = norm.rvs(avgBurstTime, avgBurstTime/6 , procNumber)
    priorList = norm.rvs(priorNum, 9/6, procNumber)
    f = open(fileName, 'a')   
    for i,j in zip(normalDisList, priorList):
        n = int(i)
        r = random.randint(0,69) 
        p = int(j)
        f.write(str(n) +' '+ str(r) + ' '+ str(p) + '\n')

def normalDis(fileName, avgBurstTime, procNumber):
    normalDisList = norm.rvs(avgBurstTime, avgBurstTime/6 , procNumber)
    f = open(fileName, 'a')   
    for i in normalDisList:
        n = int(i)
        r = random.randint(0,69) 
        p = random.randint(0,9)
        f.write(str(n) +' '+ str(r) + ' '+ str(p) + '\n')

