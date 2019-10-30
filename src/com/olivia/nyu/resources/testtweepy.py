#!/usr/bin/python
# -*- coding: UTF-8 -*- 
import tweepy
import sys
import re
reload(sys)
sys.setdefaultencoding('utf-8')
#clean the file
with open("a.txt","w") as f:
    f.truncate()

#find followers
def followers(user):

    followers = api.followers_ids(user)

    i = 0  
    for tweeter in followers:
        i += 1
        if i > 1000: #up to 1000 followers
            break
        print str(i) + "START"
        if usertweets(str(tweeter), i) == 0:
            i -= 1
    print "----Done-----"

#print out user's tweets
def usertweets(user, num):  

    try:
        with open("a.txt","a") as f: 
            i = 1 
            flag = 1
            status = 0
            for tweet in tweepy.Cursor(api.user_timeline, id = user).items():
                status = 1
                if flag == 1:
                    f.write("<user" + str(num) + ">" + user + "</user" + str(num) + ">\n")
                    flag = 0

                if re.match('RT', tweet.text) == None:
                    f.write("<tweet" + str(i) + ">" + tweet.text + "</tweet" + str(i) + ">\n") 
                    i += 1
                if i > 200:#up to 200 tweets for each follower
                    break 
        print str(num) + "SUCCESS"
        return status

    except:
        return 0

#given a user
tuser = 'nyuniversity'
 
#key and secret  
consumer_key = ""
consumer_secret = ""
access_token = ""
access_token_secret = ""
auth = tweepy.OAuthHandler(consumer_key, consumer_secret)  
auth.set_access_token(access_token, access_token_secret)  
  
#use api 
api = tweepy.API(auth) 

#find followers
followers(tuser) 


