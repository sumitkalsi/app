import React, { useState } from 'react'
import    '../public/LoginPage.css'
import axios from 'axios'
const LoginPage = () => {
    const[sign , setSign ]=useState(false)
    function onChange(){
        setSign(true)
    }

   const validateForm = (event)=>{
       event.preventDefault();
      const username = event.target.username.value;
      const email = event.target.email.value;
      const password= event.target.password.value;

      if (username=="") {
      axios.post("http://localhost:8080/login",{email,password})
      .then((response)=>{console.log(response.data)})
      .catch(error=>console.log(error)  , setSign());
      }else{
        axios.post("http://localhost:8080/register",{username,email,password})
        .then((response)=>{console.log(response.data)})
        .catch(error=>console.log(error));
      }
   }



  return (
   <div className="container">
    <div  className="login-container">
    <h2 >{sign?"register":"login"}</h2>
    <form  onSubmit={validateForm}>
    <div  className={sign?"form-group":"display-none"}>
            <label for="username">username</label>
            <input type="text" id="username" name="username"  />
        </div>
        <div className="form-group">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" required />
        </div>
        <div  className="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password"  required/>
        </div>
        <div  className="form-group">
            <button type="submit" >{sign?"register":"login"}</button>
            
        </div>
    </form>
    <button id="signUp" onClick={onChange} >sign up</button>
</div>
</div>
  )
}

export default LoginPage;
