# project_1_CTS
A web app using servlet and jdbc 


Setup before Running the porject ->

1.Please copy paste the path of the RegServlet if the file is not voterLogin.html->form->action if it is not working.

2.You can find the Schema used Below,
        create database newVoting;
        use newVoting;

        -- Voter Table
        create table voter(aadhar bigint primary key,phoneNo double,address varchar(50),email varchar(50),password varchar(50),name varchar(50),voteStatus int);
        alter table voter 
        alter voteStatus set Default 0;


        -- Party
        create table party(party_id int primary key,party_name varchar(20),party_number varchar(20),contact_number varchar(20));

        -- Party Members 
        create table partyMembers(member_id int primary key,member_name varchar(30),party_id int,party_name varchar(20),foreign key(party_id) references party(party_id));


        select * from voter;
3. There are 4 packages in this project ,
A)Files starting with voter got to "voter" package,
B)Files Starting with party go to "party" package,
C)Files starting with partyMember go to "partyMember" package.
D)Rest of the files go to the Default Package.
