import { useEffect, useState } from "react";

export const useAnimate = () => {
    const [animate, setAnimate] = useState(true);

    const keyboardListenerCallback = (e) => {
        if (e.key === ' ') {
            setAnimate(false);
        }
    }

    useEffect(() => {
        window.addEventListener('keydown', keyboardListenerCallback);
    }, [setAnimate]);

    return animate;
}
