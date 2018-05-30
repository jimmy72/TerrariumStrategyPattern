# TerrariumStrategyPattern
A terrarium designed with the strategy pattern (java console application)

This is a java console application that represents a terrarium.
The terrarium is a two dimensional array (6 x 6).
When the program starts, some organisms (human, leopard, buffalo, palm tree) are added to the terrarium and the first day (matrix)is shown.

The user can now choose to see the next day. That's when the action begins.
Each organism tries to interact with the organism to it's right side.

A human can fight another human or a leopard.
A human can move one step to the north, east, south or west if there is no organism to it's right side.

A leopard can eat a buffalo.
A leopard can fight a human or another leopard
A leopard can move one step to the north, east, south or west if there is no organism to it's right side.

A buffalo can eat a palm tree.
A buffalo can make love with another buffalo, a new buffalo is born and added to the terrarium.
A buffalo can move one step to the north, east, south or west if there is no organism to it's right side.

A palm tree can only be eaten by the buffalo

An organism can only do one of these actions each day.

At the end of each day, an extra palm tree is added to the terrarium.

The user can choose to terminate the program by pressing s + enter.

When the terrarium is full, the program terminates automatically.
