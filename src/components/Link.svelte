<script lang="ts">
  import { redirect } from "../utils/redirect";

  export let href: string;
  export let styles: string = "";
</script>

<button
  on:click={(event) => redirect(event, href)}
  class="text-onBackground {styles}"
>
  <slot />
</button>
