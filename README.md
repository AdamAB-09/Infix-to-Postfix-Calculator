## Calculator Project CS2800
This is my second year project in Software Engineering, for which I've been assigned to build a calculator that can be used
by anybody and is able to evaluate infix or postfix expressions. This calculator will be able to process expressions that
use multiplication, division, addition and subtraction. Parentheses will be accepted as well.

## Version

Project versions:

* Version 0.1
* Version 1.1

## Project status
I have been able to successfully implement all the necessary features to make the GUI work and interact with user. It's able to
process infix/postfix expressions, output multiple error messages to the user and reset the answer text box of recently. I wanted
to also implement an ASCII view of the calculator so the user has a choice of use, however it seems the GUI is the furthest
I'll be able to implement.

## How to use
It's very simple to use. You type your expression within the expression text box as prompted and press the calculate button
to receive an answer. Integers and only the four operators should be used! If you want to reset the answer box, simply
press the reset button and it will clear the result. The radio buttons correspond to whether you're inserting an infix or postfix
expression, so make sure the right button is activated. The calculator is also quite sensitive, expressions need to be
inserted in a certain way. Using parentheses should have a space between the bracket and the operand/operator. This is the
same with operators, they need to be spaced out between the operands. For instance: `5 + 2` and `( 5 + 2 )` is valid,
however `5+2` and `(5 + 2)` is invalid. 

## Built with
[Maven](https://maven.apache.org/)

[Scenebuilder](https://gluonhq.com/products/scene-builder/)
