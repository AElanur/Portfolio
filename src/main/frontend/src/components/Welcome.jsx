
import index                    from './view/index';
import {useState}               from 'react';
import axios                    from 'axios';

function welcome() {
    function authUser() {
        // store username and password in variables
        let uName = document.getElementById('uName').value;
        let pWord = document.getElementById('pWord').value;
        axios.post('http://localhost:3000/api/auth', {
            username: uName,
            password: pWord
        }).then((response) => {
            console.log(response.data);
            if(response === true) {
                fetch('http://localhost:3000/api/index').then(r => r.json()).then((data) => {
                    console.log(data);
                });
            }
        }).catch((error) => {
            console.log(error);
        });
    }

    return (
        <div>
                <h1 className="text-3xl font-bold p-5 flex flex-col">
                    Hello world!
                    <div className="flex flex-col space-y-5">
                        <div className="flex flex-col space-y-3">
                            <span>Gebruikersnaam</span>
                            <input type="text" name="uName" id="uName" />
                        </div>

                        <div className="flex flex-col space-y-3">
                            <span>Wachtwoord</span>
                            <input type="password" name="pWord" id="pWord" />
                        </div>

                        <div className="flex justify-end">
                            <button onClick={authUser}
                                    className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                                Login
                            </button>
                        </div>
                    </div>
                </h1>            
            </div>
    )
}

export default welcome