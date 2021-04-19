import nltk
from nltk.util import bigrams, trigrams
from nltk import word_tokenize
from nltk.util import ngrams
from collections import Counter, defaultdict
import re
import glob
import os
from decimal import *
import time
start_time = time.time()

def uniGramModel(unigram):
    uGram = Counter(list(unigram))

    totalCount = 0
    for i in uGram.elements():
        totalCount = totalCount + uGram[i]
        
    problist = []
    for i in uGram.elements():
        getcontext().prec = 10
        prob = Decimal(uGram[i])/Decimal(totalCount)
        problist.append(prob)
    
    max100prob_list = [] 
    max100word_list = [] 
    for i in range(0, 100):  
        max1 = 0
        k = 0
        for j in range(len(problist)):      
            if problist[j] > max1: 
                max1 = problist[j];
                k = j
        unigram.remove(unigram[k])
        problist.remove(max1)
        max100word_list.append(unigram[k])
        max100prob_list.append(max1) 
    
    merged_list = [(max100word_list[i], max100prob_list[i]) for i in range(0, len(max100word_list))] 
    print (merged_list)
    print("--- %s seconds ---" % (time.time() - start_time))
       
           
def biGramModel(bigram):
    biGram = Counter(list(bigram))
    totalCount = 0
    for i in biGram.elements():
        totalCount = totalCount + biGram[i]

    problist = []
    for i in biGram.elements():
        getcontext().prec = 10
        prob = Decimal(biGram[i])/Decimal(totalCount)
        problist.append(prob)

    max100prob_list = [] 
    max100word_list = [] 
    for i in range(0, 100):  
        max1 = 0
        k = 0
        for j in range(len(problist)):      
            if problist[j] > max1: 
                max1 = problist[j];
                k = j

        #list(bigram).remove(bigram[k])
        problist.remove(max1)
        #max100word_list.append(bigram[k])
        max100prob_list.append(max1) 
        #bigram[k] = 0
        #problist[k] = 0
    
    #merged_list = [(max100word_list[i], max100prob_list[i]) for i in range(0, len(max100word_list))] 
    #print (merged_list)
    print (max100prob_list)
    print("--- %s seconds ---" % (time.time() - start_time))
        
    
def triGramModel(unigram):
    uniGram = Counter(list(unigram))
    totalCount = 0
    for i in uniGram.elements():
        totalCount = totalCount + uniGram[i]

    problist = []
    for i in uniGram.elements():
        getcontext().prec = 10
        prob = Decimal(uniGram[i])/Decimal(totalCount)
        problist.append(prob)

    max100prob_list = [] 
    max100word_list = [] 
    for i in range(0, 100):  
        max1 = 0
        k = 0
        for j in range(len(problist)):      
            if problist[j] > max1: 
                max1 = problist[j];
                k = j

        #list(bigram).remove(bigram[k])
        problist.remove(max1)
        #max100word_list.append(bigram[k])
        max100prob_list.append(max1) 
        #bigram[k] = 0
        #problist[k] = 0
    
    #merged_list = [(max100word_list[i], max100prob_list[i]) for i in range(0, len(max100word_list))] 
    #print (merged_list)
    print (max100prob_list)
    print("--- %s seconds ---" % (time.time() - start_time))
            

os.chdir(r'C:\Users\Toshiba\Desktop\NLP\2014510048_Melda_Karadag\Novel-Samples')
myFiles = glob.glob('*.txt')
print(myFiles)

for file in myFiles:
    with open(file) as f:
      text = " ".join([x.strip() for x in f]) 
      text = re.sub(r'[^\w\s]','',text)
      unigram = word_tokenize(text)
      bigram = bigrams(unigram)
      trigram =  trigrams(unigram)
      print("Unigram Model for file", file)
      uniGramModel(unigram)
      print("Bigram Model for file", file)
      biGramModel(bigram)
      print("Trigram Model for file", file)
      triGramModel(trigram)




