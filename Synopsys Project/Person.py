from collections import namedtuple

Person = namedtuple("person", "name triage")

x = Person("lit", 2)
print(x.triage)
