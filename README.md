# Machine-Learning-Triage-Prediction
A machine-learning algorithm designed to predict patient triage scores in the emergency room. 
Created for Synopsys 2019 Science Fair.

## Overview
This program uses a Java-based GUI along with a Python-based machine-learning algorithm to predict and appropriately display triage scores to the user.

The Python files are found in the folder "Synopsys Project" and the Java files are found in the folder "Triage System GUI". 

## How it Works
2 Convolutional Neural Networks modeled on ER patient data are made using the Python library TensorFlow. The patient data is sent to the algorithm in the form of the patient's symptoms and vitals signs along with their diagnosed triage scores (Model 1: (features = symptoms, labels = triage scores), Model 2: (features = vitals, labels = triage scores)).

This is achieved through:
1. Parsing the data.
2. Determining which pieces of data are patient symptoms and patient vitals.
3. Allocating some symptoms data for training symptoms model.
3. Allocating some vitals data for training vitals model.
4. Testing each model with the data leftover by weighing symptom and vital model predictions **(EXPLAINED IN OPTIMIZING DATA)**

To predict new triage scores, data is passed through a Java GUI built with WindowBuilder. 

This is achieved through:
1. Java GUI receives symptoms and vitals.
2. Passes it to Python program.
3. Java program visually responds to Python program response (Through a pie chart)
  - Nurse can click on triage color on chart to reveal table of patients within that triage

Picture of Nurse GUI with pie chart: 
![](Screen%20Shots/NurseGUIPieChart.png)

Picture of Nurse GUI after clicking on triage 5:
![](Screen%20Shots/NurseGUITable.png)

## Problems
Intuitively, it may seem that training a single model with symptoms and vitals as features is acceptable. But this will result in a model that is ~50-60% accurate. However, this is not an accurate representation of the model's ability to predict triage scores. 

To appropriately test the model, rather than basing accuracy on whether the model is right or wrong, it should be determined by observing how far away the model is from the correct answer.

Accuracy Calculation:
![](Screen%20Shots/AccurateAccuracy.png)

Still, this does not improve the model's accuracy by much (~3% increase). As a result, optimizations have to be taken in the form of what features are considered when making a prediction.

## Optimizing Data
Firstly, not all patient symptoms are valuable. The same information that a symptom provides could be found in their vital signs. This should mean that only the most important symptoms should be considered and that these key symptoms should be kept the same for all patients. This is easily achieved with an array or dictionary. Instantly, accuracy is bumped up to ~75-85 percent. 

In addition, not all patient symptoms are reliable, as someone might exaggerate their conditions. This means that vital signs should have higher precedence than symptoms when determining a score (vital signs should be **weighed** more). 

### Weighing Symptoms and Models
A novel approach to this problem is to use 2 machine learning models. 1 model considers only symptoms while the other considers only vitals (data labeled with triage scores). Given a patient with certain vitals and symptoms, 2 different scores are given based on their vital signs and symptoms. Then, their vital score is multiplied by 0.85 and their symptom score is multiplied by 0.15. These values are then added, thus providing a final score. 

This process can be more concisely illustrated with the following equation: 
![](Screen%20Shots/TriageScoreEquation.png)

This equation was found by comparing the vital prediction with the weighted prediction (See Machine Learning Data Analytics for more details). 

However, are symptoms really necessary?


## Machine Learning Data Analytics
To determine whether weighing the models were more accurate than not including symptoms at all, these are graphs comparing the percent loss with the regular prediction (1 model) and the weighted prediction (2 models): 
![](Screen%20Shots/DataAnalytics.png)

It is seen that the percent error for the weighted prediction (percent error for equation) is always lower than the vital prediction, thus proving that weighing values is more effective.

## Communicating Between Languages
Communicating between the Java and Python programs was done through a text document. A Java thread would send information via document, where the waiting Python program would collect the data and output a number into the document. The Java thread would collect the number and then display an appropriate visual response. 
