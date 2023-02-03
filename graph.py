import matplotlib.pyplot as plt
import numpy as np


# create a dictionary of data from a file in csv format
def createData(filename):
    data = {}
    with open(filename) as f:
        for line in f:
            (key, val) = line.split(',')
            data[int(key)] = int(val)
    return data

def plotData(data):
    x = []
    y = []
    for key in data:
        x.append(key)
        y.append(data[key])
    plt.plot(x,y)
    plt.show(block=True)

plots = createData('graphPlots.txt')
plotData(plots)
