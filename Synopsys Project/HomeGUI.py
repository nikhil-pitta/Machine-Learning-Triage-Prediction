from tkinter import *

root = Tk()
root.geometry("800x400+0+0")
root.title("ER Thing")

top = Frame(root, width=800, height=50)
label1 = Label(top, text="fisrt:")
label2 = Label(top, text="Middle:")
label3 = Label(top, text="Surmame")

entry1 = Entry(top)
entry2 = Entry(top)
entry3 = Entry(top)

bottomSubmit = Button(top, text="     Submit      ")

label1.grid(row=0, column=0, padx=10, pady=10)
label2.grid(row=1, column=0)
label3.grid(row=2, column=0)

entry1.grid(row=0, column=1)
entry2.grid(row=1, column=1)
entry3.grid(row=2, column=1)

bottomSubmit.grid(row=3, columnspan=2)

top.grid(row=0, column=0)

frame2 = Frame(root)

entry4 = Entry(frame2)
entry4.grid(row=0, column=0)

entry5 = Entry(frame2)
entry5.grid(row=1, column=0)

entry6 = Entry(frame2)
entry6.grid(row=2, column=0)


frame2.grid(row=0, column=1)

mainloop()
