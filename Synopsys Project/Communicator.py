from collections import namedtuple
from Algorithm import predict
import matplotlib.pyplot as plt
import matplotlib.pyplot as test
import time
import numpy as np
import pandas as pd
from math import ceil


# Create a 'Person Object'
Person = namedtuple("person", "name triage")


triage = [[] for x in range(5)]


def createChart():

    plt.figure(figsize=(5, 5))

    labels = ["1", "2", "3", "4", "5"]
    values = [len(triage[0]), len(triage[1]), len(triage[2]), len(triage[3]), len(triage[4])]
    #values = [1, 1, 1, 1, 1]
    colors = ['r', 'g', 'b', 'c', 'y']

    plt.pie(values, labels=labels, autopct="%.1f%%", colors=colors)
    plt.title("Current Triage Levels")
    plt.legend()

    plt.savefig("/Users/nikhil/Desktop/Synopsys Project/TriageChart.png",
                bbox_inches='tight', transparent=True)


def createTable():
    fig, ax = plt.subplots()
    '''# hide axes
    fig.patch.set_visible(False)
    ax.axis('off')
    ax.axis('tight')'''

    fig = plt.figure(figsize=(6, 1))

    data1 = []

    for i in range(len(triage[0])):
        num = triage[0][i].triage
        num = ceil(num * 100) / 100.0
        data1.append([triage[0][i].name, num])

    df = pd.DataFrame(data=data1, columns=['Name', 'Triage Score'])

    the_table = ax.table(cellText=df.values, colLabels=df.columns, loc='center')

    # for increasing the heught of each cell
    table_props = the_table.properties()
    table_cells = table_props['child_artists']
    for cell in table_cells:
        cell.set_height(0.1)

    # for amking the text of each cell in the center
    cells = the_table.properties()["celld"]
    for i in range(0, len(triage[0])+1):
        for j in range(0, 2):
            cells[i, j]._loc = 'center'

############
    plt.axis('off')
    plt.grid('off')

    # for making colors to the cells
    the_table._cells[(0, 0)].set_facecolor("#56b5fd")
    the_table._cells[(0, 1)].set_facecolor("#1ac3f5")

    fig.tight_layout()

    plt.savefig("/Users/nikhil/Desktop/Synopsys Project/TriageTable.png")

    # plt.show()

#######################################################################################


def createTable2():
    '''TABLEs'''

    for i in range(0, 5):
        fig = plt.figure(figsize=(6, 1))

        #t_data = ((1, 2), (3, 4))
        data1 = []

        if len(triage[i]) is not 0:
            for j in range(len(triage[i])):
                data1.append([triage[i][j].name, triage[i][j].triage])

                '''MAKE THEM SORTED'''
            # data1.sort(key=int)

            table = plt.table(cellText=data1, colLabels=('Name', 'Triage Score'), loc='center')

            # table._cells[(0, 0)].set_facecolor("#56b5fd")
            # table._cells[(0, 1)].set_facecolor("#56b5fd")

            table_props = table.properties()
            table_cells = table_props['child_artists']
            for cell in table_cells:
                cell.set_height(0.5)

            cells = table.properties()["celld"]
            for j in range(0, len(triage[i])+1):
                for k in range(0, 2):
                    cells[j, k]._loc = 'center'

            # fig.tight_layout()

            plt.axis('off')
            plt.grid('off')

            plt.savefig('/Users/nikhil/Desktop/Synopsys Project/TriageTable' + str(i+1) + '.png',
                        bbox_inches="tight", transparent=True)


while True:

    with open('Person.txt', 'a+') as f:
        f.seek(0)

        read1 = False
        read = False

        if f.readline().strip() is not '':
            read1 = True

        for i in range(6):
            f.readline()

        if f.readline().strip() is '':
            read = True

        if read and read1 is True:
            f.seek(0)
            name = f.readline()
            sp = float(f.readline())
            temp = float(f.readline())
            heart = float(f.readline())
            resp = float(f.readline())
            bp = float(f.readline())

            # for creating array used to make symptoms
##########################################################################################
            symptoms = f.readline()
            realS = [0 for x in range(6)]

            if 'fever'.lower() in symptoms.lower():
                realS[0] = 1
            if 'vomiting'.lower() in symptoms.lower():
                realS[1] = 1
            if 'diarrhea'.lower() in symptoms.lower():
                realS[2] = 1
            if 'shortness of breath'.lower() in symptoms.lower():
                realS[3] = 1
            if 'wheezing'.lower() in symptoms.lower():
                realS[4] = 1

            print(realS)
##########################################################################################

            triageNum = predict(sp, temp, heart, resp, bp, realS)

            person = Person(name, triageNum[0])

            index = int(triageNum)
            index -= 1
            triage[index].append(person)

            # REMEMER TO SORTTTT

            f.write(str(triageNum[0]))
            createChart()
            createTable2()

            time.sleep(3)
