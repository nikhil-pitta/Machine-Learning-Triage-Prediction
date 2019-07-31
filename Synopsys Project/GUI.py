import tkinter as tk
from Algorithm import predict

# storage for people
triage = [[] for x in range(5)]

rowLevelLabel = 0
rowLevelEntry = 0

root = tk.Tk()

# Things to make GUI for Triage
triageLabel = tk.Label(root, text="Current Triage")
triageLabel.grid(row=rowLevelLabel, column=10)

level1 = tk.Label(root, text="Level 1: ")
level2 = tk.Label(root, text="Level 2: ")
level3 = tk.Label(root, text="Level 3: ")
level4 = tk.Label(root, text="Level 4: ")
level5 = tk.Label(root, text="Level 5: ")

levelColumn = 4

level1.grid(row=rowLevelLabel+2, column=levelColumn, sticky=tk.E)
level2.grid(row=rowLevelLabel+4, column=levelColumn, sticky=tk.E)
level3.grid(row=rowLevelLabel+6, column=levelColumn, sticky=tk.E)
level4.grid(row=rowLevelLabel+8, column=levelColumn, sticky=tk.E)
level5.grid(row=rowLevelLabel+10, column=levelColumn, sticky=tk.E)


# creating labels
nameLabel1 = tk.Label(root, text="First Name: ")
nameLabel2 = tk.Label(root, text="Last Name: ")
spoLabel = tk.Label(root, text="SpO:")
tempLabel = tk.Label(root, text="Temperature:")
heartLabel = tk.Label(root, text="Heart Rate:")
respLabel = tk.Label(root, text="Respiratory Rate:")
bloodLabel = tk.Label(root, text="Blood Pressure:")

# organizing labels
nameLabel1.grid(row=rowLevelLabel, column=0, sticky=tk.E)
nameLabel2.grid(row=rowLevelLabel, column=4, sticky=tk.E)
rowLevelLabel += 2

spoLabel.grid(row=rowLevelLabel, sticky=tk.E)
rowLevelLabel += 2

tempLabel.grid(row=rowLevelLabel, sticky=tk.E)
rowLevelLabel += 2

heartLabel.grid(row=rowLevelLabel, sticky=tk.E)
rowLevelLabel += 2

respLabel.grid(row=rowLevelLabel, sticky=tk.E)
rowLevelLabel += 2

bloodLabel.grid(row=rowLevelLabel, sticky=tk.E)
rowLevelLabel += 2

triageLabel.grid()

# creating entries
nameEntry1 = tk.Entry(root)
nameEntry2 = tk.Entry(root)
spoEntry = tk.Entry(root)
tempEntry = tk.Entry(root)
heartEntry = tk.Entry(root)
respEntry = tk.Entry(root)
bloodEntry = tk.Entry(root)

# organizing entries
nameEntry1.grid(row=rowLevelEntry, column=1)

nameEntry2.grid(row=rowLevelEntry, column=5)
rowLevelEntry += 2

spoEntry.grid(row=rowLevelEntry, column=1)
rowLevelEntry += 2

tempEntry.grid(row=rowLevelEntry, column=1)
rowLevelEntry += 2

heartEntry.grid(row=rowLevelEntry, column=1)
rowLevelEntry += 2

respEntry.grid(row=rowLevelEntry, column=1)
rowLevelEntry += 2

bloodEntry.grid(row=rowLevelEntry, column=1)
rowLevelEntry += 2

# use input from buttons to provide prediction


def getInput():
    spo = float(spoEntry.get())
    temp = float(tempEntry.get())
    heart = float(heartEntry.get())
    resp = float(respEntry.get())

    blood1 = (float(bloodEntry.get().split("/")[0].strip()))
    blood2 = (float(bloodEntry.get().split("/")[1].strip()))
    realBlood = blood1/blood2

    triageNum = int(predict(spo, temp, heart, resp, realBlood))

    first = nameEntry1.get()
    last = nameEntry2.get()
    name = first + " " + last

    triage[triageNum-1].append(name)

    displayTriage()

    print(triage)

    nameEntry1.delete(0, tk.END)
    nameEntry2.delete(0, tk.END)
    spoEntry.delete(0, tk.END)
    tempEntry.delete(0, tk.END)
    heartEntry.delete(0, tk.END)
    respEntry.delete(0, tk.END)
    bloodEntry.delete(0, tk.END)


# in order to display traige

locationRow = 0
locationColumn = 5


def displayTriage():
    for row in range(len(triage)):
        for col in range(len(triage[row])):
            displayLabel = tk.Label(root, text=triage[row][col])
            print("triage:" + triage[row][col])
            displayLabel.grid(row=(locationRow+(2+row*2)), column=locationColumn+col)


            # creating button
button = tk.Button(root, text="Triage", command=getInput, height=2, width=20)
button.grid(columnspan=2)

tk.mainloop()
