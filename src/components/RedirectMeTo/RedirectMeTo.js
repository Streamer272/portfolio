import { useState } from 'react';
import { Redirect } from "react-router-dom";

export let redirectMeTo = (url = "/", force = false) => {}

export const RedirectContainer = () => {
    const [redirect, setRedirect] = useState(null);

    redirectMeTo = (url = "/", force = false) => {
        if (force) {
            window.location = url;
        }
        else {
            setRedirect(
                <Redirect to={ url } />
            );
        }
    }

    return redirect;
}
