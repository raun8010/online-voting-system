function insert() {
    var firstName = document.getElementById("firstname").value;
    var lastName = document.getElementById("lastname").value;
    var phoneNo = document.getElementById("phoneno").value;
    var candidate;
    var Selector= document.getElementsByName('selector');
    for (i=0; i< Selector.length; i++) {
        if (Selector[i].checked)
        candidate=Selector[i].value;
    }
    var conver ={
        userFirstName : firstName ,
        userLastName : lastName ,
        userPhoneNo : phoneNo ,
        candidateId : candidate 
        
    }
    var masg;
    var connection1 = new XMLHttpRequest();
    var url = 'http://localhost:8080//users';
    connection1.open('post' , url);
    var details=JSON.stringify(conver);
    connection1.setRequestHeader("Content-type","application/json");
    connection1.onload=function(){
        mesg= connection1.responseText;
        console.log(mesg)
        if(mesg.localeCompare("pass")!=0)
        {
            alert("You have already voted.Thanks for Voting");
            location.href="../webpage.html"
        }
        else{
            location.href="Result.html"
        }
    }
    connection1.send(details);

    }