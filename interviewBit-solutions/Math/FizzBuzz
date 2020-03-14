/*

Given a positive integer N, print all the integers from 1 to N. But for multiples of 3 print “Fizz” instead of 
the number and for the multiples of 5 print “Buzz”. Also for number which are multiple of 3 and 5, prints “FizzBuzz”.

Example

N = 5
Return: [1 2 Fizz 4 Buzz]
Note: Instead of printing the answer, you have to return it as list of strings.

*/

Solution:

vector<string> Solution::fizzBuzz(int n) {
    
    vector<string>s;
    for(int i = 1; i<=n; i++){
        if(i%3 == 0 && i%5==0){
            s.push_back("FizzBuzz");
        }
        else if(i%3==0){
            s.push_back("Fizz");
        }
        else if(i%5==0){
            s.push_back("Buzz");
        }
        else{
            //string t = "";
            //t = t + (char)(i+48);
            string t = to_string(i);
            s.push_back(t);
        }
    }
    return s;
}
