/**
 * 
 */

 // 사용자 객체
 // 프로퍼티 id,password,email,name
function User(id,password,email,name){
	 this.id = id;
	 this.password = password;
	 this.email = email;
	 this.name = name;
}

let user1 = new User("aaa","1111","a1a1@naver.com","가유저");
let user2 = new User("bbb","2222","b2b2@naver.com","나유저");
let user3 = new User("ccc","3333","c3c3@naver.com","다유저");
let user4 = new User("ddd","4444","d4d4@naver.com","라유저");
let user5 = new User("eee","5555","e5e5@naver.com","마유저");
let user6 = new User("fff","6666","f6f6@naver.com","바유저");
let user7 = new User("ggg","7777","g7g7@naver.com","사유저");

let user_list = [user1,user2,user3,user4,user5,user6,user7];

// 영화 객체
// 프로퍼티 name,imageUrl
function Movie(name,url){
	this.name = name;
	this.url = url;
}

let movie1 = new Movie("1917","./images/1917.jpg");
let movie2 = new Movie("더_마블스","./images/더_마블스.jpg");
let movie3 = new Movie("범죄도시2","./images/범죄도시2.jpg");
let movie4 = new Movie("암살","./images/암살.jpg");
let movie5 = new Movie("이웃집_토토로","./images/이웃집_토토로.jpg");


let movie_list = [movie1, movie2,movie3,movie4,movie5];

// user와 movie와 date에 객체를 넘겨줘야함
// 영화 시청 기록 객체
// 프로퍼티 user, movie, watched_date
function Movie_watched_history(user,movie, date){
	this.user = user;
	this.movie = movie;
	this.watched_date = date;
}

let history1 = new Movie_watched_history(user1,movie1,new Date("2023-11-11"));
let history2 = new Movie_watched_history(user1,movie5,new Date("2023-11-12"));
let history3 = new Movie_watched_history(user2,movie3,new Date("2023-11-11"));
let history4 = new Movie_watched_history(user3,movie1,new Date("2023-11-11"));
let history5 = new Movie_watched_history(user3,movie4,new Date("2023-11-12"));
let history6 = new Movie_watched_history(user4,movie2,new Date("2023-11-11"));
let history7 = new Movie_watched_history(user4,movie4,new Date("2023-11-12"));
let history8 = new Movie_watched_history(user6,movie1,new Date("2023-11-11"));
let history9 = new Movie_watched_history(user6,movie2,new Date("2023-11-12"));
let history10 = new Movie_watched_history(user6,movie3,new Date("2023-11-13"));
let history11 = new Movie_watched_history(user6,movie1,new Date("2023-11-14"));
let history12 = new Movie_watched_history(user7,movie5,new Date("2023-11-11"));
let history13 = new Movie_watched_history(user1,movie2,new Date("2022-02-11"));
let history14 = new Movie_watched_history(user1,movie4,new Date("2023-10-11"));
let history15 = new Movie_watched_history(user1,movie5,new Date("2022-01-09"));
let history16 = new Movie_watched_history(user1,movie2,new Date("2023-10-12"));
let history17 = new Movie_watched_history(user1,movie4,new Date("2023-04-15"));

let history_list = [history1,history2,history3,history4,history5,history6,history7,history8,history9,history10,history11,history12,
								history13,history14,history15,history16,history17];

// history 객체를 넘겨줘야함
// 프로퍼티 user, movie, write_date
function Review_history(history,write_date){
	this.user = history.user;
	this.movie = history.movie;
	this.write_date = write_date;
}

let review_history1 = new Review_history(history1,new Date("2023-11-12"));
let review_history2 = new Review_history(history2,new Date("2023-11-13"));
let review_history3 = new Review_history(history3,new Date("2023-11-14"));
let review_history4 = new Review_history(history13,new Date("2023-11-13"));
let review_history5 = new Review_history(history14,new Date("2023-11-14"));
let review_history6 = new Review_history(history15,new Date("2023-11-14"));
let review_history7 = new Review_history(history16,new Date("2023-11-15"));

let review_history_list = [review_history1,review_history2,review_history3,review_history4,review_history5,review_history6,review_history7];

export {movie_list,user_list,history_list,review_history_list,User,Movie,Movie_watched_history,Review_history};



