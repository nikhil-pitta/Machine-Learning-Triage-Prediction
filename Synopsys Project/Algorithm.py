from nltk.tokenize import word_tokenize
from sklearn import neighbors
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split

# 1-5, 5=no priority, 1=prioritize

# actual prediction


def predict(spo, temp, heart, resp, bp, s):
    vitals = knn.predict([[spo, temp, heart, resp, bp]])
    symptoms = knn2.predict([s])

    triage = 0.85*vitals + 0.15*symptoms

    return triage


# data storage for vitals
numPeople = 40
# person = [spo, temp, heart rate, respiratory rate, bp]
people = [[] for x in range(numPeople)]
# pita scale label
label = []

# data storage for symptoms
peopleSymptoms = [[0 for x in range(6)] for y in range(numPeople)]
# symptoms = [fever, vomiting, diarrehea, shortness of breath, wheezing, cough]

with open('vitals.txt', 'r') as f:
    currentPerson = 0
    add = False
    for line in f:
        line = line.strip()

        # For extracting vitals of people
        if 'Case Study' and 'continued' in line:
            currentPerson += 1
            add = True

        if 'Vital Signs' in line and add is True:
            vitals = line.split(',')
            spo = float(vitals[0].split('SpO2')[1][0:4])/100
            temp = float(vitals[1].split('Temperature')[1].strip())
            heart = float(vitals[2].split('Heart Rate')[1].strip())
            resp = float(vitals[3].split('Respiratory Rate')[1].strip())
            bp = vitals[4].split('Blood Pressure')[1].split('/')
            realBp = float(bp[0].strip())/float(bp[1].strip())

            people[currentPerson-1].append(spo)
            people[currentPerson-1].append(temp)
            people[currentPerson-1].append(heart)
            people[currentPerson-1].append(resp)
            people[currentPerson-1].append(realBp)

        # For Extracting Symptoms
        if 'Chief Complaint' in line and add is True:
            if 'fever'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][0] = 1
            if 'vomiting'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][1] = 1
            if 'diarrhea'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][2] = 1
            if 'shortness of breath'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][3] = 1
            if 'wheezing'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][4] = 1

        if 'Influenza Symptoms' in line and add is True:
            if 'fever'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][0] = 1
            if 'vomiting'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][1] = 1
            if 'diarrhea'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][2] = 1
            if 'shortness of breath'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][3] = 1
            if 'wheezing'.lower() in line.lower():
                peopleSymptoms[currentPerson-1][4] = 1

        # For making labels
        if 'PITA Score' in line and add is True:
            score = int(line.split(':')[1])
            label.append(score)
            add = False


# Actual Machine Learning Stuff

# for vital signs
X_train, X_test, y_train, y_test = train_test_split(people, label, test_size=.3)

# for symptoms
X_train2, X_test2, y_train2, y_test2 = train_test_split(peopleSymptoms, label, test_size=.3)

knn = neighbors.KNeighborsClassifier(n_neighbors=5)
knn2 = neighbors.KNeighborsClassifier(n_neighbors=5)

knn.fit(X_train, y_train)
knn2.fit(X_train2, y_train2)

predictions = knn.predict(X_test)
predictions2 = knn2.predict(X_test2)


# print(accuracy_score(y_test, predictions))
# more accurate way to represent accuracy - finds average percent error

currPer = 0
fixedPer = 0

realPredictions = [0 for x in range(len(predictions))]

for i in range(len(predictions)):
    realPredictions[i] = predictions[i] * 0.85 + predictions2[i] * 0.15

    fixedPer += (abs(realPredictions[i] - y_test[i]))/y_test[i]
    currPer += (abs(predictions[i] - y_test[i]))/y_test[i]

currPer /= numPeople
fixedPer /= numPeople


print("original: " + str(currPer))
print("fixed: " + str(fixedPer))


# machine learning to UI
triage = [[] for x in range(5)]
print("Predictions:", predictions)
print("Predictions2:", predictions2)
print("Real Predictions:", realPredictions)
# sprint(predictions2)
print("test inputs", y_test)

# for i in range(len(predictions)):
#    triage[predictions[i] - 1].append('Person ' + str(i))

# print(triage)
