import { writable } from "svelte/store";

export const redirectPos = writable<[number, number] | undefined>(undefined);

redirectPos.subscribe((pos) => {
  console.log("redirectPos", pos);
});

export function redirect(event: MouseEvent, url: string) {
  console.log("changing");
  redirectPos.set([event.clientY, event.clientX]);

  setTimeout(() => {
    console.log("redirect to", url);
    window.location.assign(url);
  }, 300);
}
