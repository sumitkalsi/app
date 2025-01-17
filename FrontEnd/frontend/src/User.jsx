import React , {useEffect,useState} from "react"
import { getUser } from "./services/userService"
const User = () => {
const[user , setUser] = useState({})


useEffect(()=>{
  getUser().then((response)=>{
    setUser(response.data);
    console.log("getting object"+response.data)
  }).catch(()=>{console.log("not getting object")})
},[])

  return (
   <>  {user.email}
       {user.username}
   </>
        
   
    
  )
}

export default User
