import matplotlib.pyplot as plt

'''plt.figure(figsize=(5, 5))

labels = ["USE", "AFFDAF", "ADAF", "ASFAf", "ASF"]
values = [123, 23, 12, 123, 23]
colors = ['r', 'g', 'b', 'c', 'y']

plt.pie(values, labels=labels, autopct="%.1f%%", colors=colors)
plt.title("Triage")
# plt.legend()

plt.savefig("/Users/nikhil/Desktop/Synopsys Project/yeet.png",
            bbox_inches='tight', transparent=True)'''

'''import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

fig, ax = plt.subplots()

# hide axes
fig.patch.set_visible(False)
ax.axis('off')
ax.axis('tight')

df = pd.DataFrame(np.random.randn(10, 2), columns=['Name', 'Triage Score'])

ax.table(cellText=df.values, colLabels=df.columns, loc='center')

fig.tight_layout()

plt.show()'''

'''
fig = plt.figure(figsize=(6, 1))

t_data = [[1, 2], [3, 4]]
table = plt.table(cellText=t_data,
                  colLabels=('label 1', 'label 2'),
                  rowLabels=('row 1', 'row 2'),
                  loc='center')

plt.axis('off')
plt.grid('off')

plt.savefig('test2.png', bbox_inches="tight", transparent=True)
plt.show()
'''

peopleSymptoms = [0 for x in range(6)]

print(peopleSymptoms)
