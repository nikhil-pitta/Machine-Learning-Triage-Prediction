from tkinter import *

root = Tk()
root.geometry("800x400+0+0")
root.title("ER Thing")

tops = Frame(root, width=800, height=50, bg="powder blue", relief=SUNKEN)
tops.pack(side=TOP)

frame1 = Frame(root, width=400, height=350, bg="powder blue", relief=SUNKEN)
frame1.pack(side=LEFT)

frame2 = Frame(root, width=150, height=350, bg="powder blue", relief=SUNKEN)
frame2.pack(side=RIGHT)

# bd = Border Width
lblInfo = Label(tops, font=('arial', 25, 'bold'), text="REstuarnat Management System",
                fg="Steel Blue", bd=10, anchor='w')
lblInfo.grid(row=0, column=0)

lblInfo2 = Label(tops, font=('arial', 10, 'bold'), text="lmao",
                 fg="Steel Blue", bd=10, anchor='n')
lblInfo2.grid(row=1, column=0)

textInput = StringVar()
textDisplay = Entry(frame2, font=('arial', 10, 'bold'), textvariable=textInput,
                    bd=15, insertwidth=2, bg="powder blue", justify='right')
textDisplay.grid(columnspan=4)

bt7 = Button(frame2, padx=8, pady=8, bd=8, fg="black", font('arial', 20, 'bold'), text="7".)


root.mainloop()
