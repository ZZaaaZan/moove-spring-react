// import React, { useEffect } from 'react';
//
//
// const GoogleLogIn = () => {
//     function handleCallbackResponse(response){
//         console.log("Encode JWT ID token: " + response.credential);
//
//     }
//
//     useEffect(() => {
//         /* global google */
//             google.accounts.id.initialize({
//                 client_id: "8229619448-3i8pi1ns05i4dll3v0lg082rdthkrt19.apps.googleusercontent.com",
//                 callback: handleCallbackResponse
//             });
//
//             google.accounts.id.renderButton(
//                 document.getElementById("signInDiv"),
//                 { theme: "outline", size: "large"}
//
//             )
//
//     }, []);
//     return (
//         <div>
//             <div id="signInDiv"></div>
//         </div>
//     )
// }
//
// export default GoogleLogIn